package com.beeete2.android.epoxyexample.ui.friend.input

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.airbnb.epoxy.EpoxyController
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.ext.navigate
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.ui.view.addGenderOptionItemView
import com.beeete2.android.epoxyexample.ui.view.addHeaderItemView
import com.beeete2.android.epoxyexample.ui.view.addInputItemView
import com.beeete2.android.epoxyexample.ui.view.addSwitchItem
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.fragment_base.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendInputFragment : Fragment() {

    private val TAG by lazy { javaClass.simpleName }

    private val vm: FriendInputViewModel by viewModel()

    private val controller = Controller()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false).apply {
            recycler_view.apply {
                setController(controller)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setImageResource(R.drawable.ic_done)
        fab.setOnClickListener {
            vm.friend.value?.let {
                vm.done()
                navigate(R.id.friendResultFragment)
            }
        }

        vm.friend.observe(viewLifecycleOwner) {
            controller.setData(it)
        }
    }

    inner class Controller : EpoxyController() {
        private var data: Friend? = null
        private var isFirstBuild = true

        fun setData(data: Friend) {
            this.data = data
            if (isFirstBuild) {
                requestModelBuild()
                isFirstBuild = false
            } else {
                requestDelayedModelBuild(500)
            }
        }

        override fun buildModels() {
            // Name
            addHeaderItemView {
                id("name_header")
                header(R.string.name_header)
            }
            addInputItemView {
                id("first_name")
                text(data?.firstName ?: "")
                hint(R.string.first_name_hint)
                onEditTextChanged { vm.setFirstName(it) }
            }
            addInputItemView {
                id("last_name")
                text(data?.lastName ?: "")
                hint(R.string.last_name_hint)
                onEditTextChanged { vm.setLastName(it) }
            }

            // Phonetic Name
            addHeaderItemView {
                id("phonetic_name_header")
                header(R.string.phonetic_name_header)
            }
            addInputItemView {
                id("phonetic_first_name")
                text(data?.phoneticFirstName ?: "")
                hint(R.string.phonetic_first_name_hint)
                onEditTextChanged { vm.setPhoneticFirstName(it) }
            }
            addInputItemView {
                id("phonetic_last_name")
                text(data?.phoneticLastName ?: "")
                hint(R.string.phonetic_last_name_hint)
                onEditTextChanged { vm.setPhoneticLastName(it) }
            }

            // Gender
            addHeaderItemView {
                id("gender_header")
                header(R.string.gender_header)
            }
            addGenderOptionItemView {
                id("gender")
                gender(data?.gender)
                maleCheckedChangeListener { _, _, _, isChecked, _ ->
                    if (isChecked) vm.setGenderMale()
                }
                femaleCheckedChangeListener { _, _, _, isChecked, _ ->
                    if (isChecked) vm.setGenderFemale()
                }
                unknownCheckedChangeListener { _, _, _, isChecked, _ ->
                    if (isChecked) vm.setGenderUnknown()
                }
            }

            // Address
            addHeaderItemView {
                id("address_header")
                header(R.string.address_header)
            }
            addInputItemView {
                id("address")
                text(data?.address ?: "")
                hint(R.string.address_hint)
                onEditTextChanged { vm.setAddress(it) }
            }

            // More
            addHeaderItemView {
                id("more_header")
                header(R.string.more_header)
            }
            addSwitchItem {
                id("block")
                label(R.string.block_switch_label)
                checked(data?.block ?: false)
                checkedChangeListener { _, _, _, isChecked, _ ->
                    data?.let {
                        if (it.block != isChecked) vm.setBlock(isChecked)
                    }
                }
            }
            addSwitchItem {
                id("favorite")
                label(R.string.favorite_switch_label)
                checked(data?.favorite ?: false)
                checkedChangeListener { _, _, _, isChecked, _ ->
                    data?.let {
                        if (it.favorite != isChecked) vm.setFavorite(isChecked)
                    }
                }
            }
            addInputItemView {
                id("notes")
                text(data?.notes ?: "")
                hint(R.string.notes_hint)
                onEditTextChanged { vm.setNotes(it) }
            }
        }
    }

    override fun onDestroyView() {
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
        super.onDestroyView()
    }
}
