package com.beeete2.android.epoxyexample.ui.friend.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.airbnb.epoxy.TypedEpoxyController
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.ext.blockText
import com.beeete2.android.epoxyexample.ext.favoriteText
import com.beeete2.android.epoxyexample.ext.text
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.ui.view.addFieldItemView
import com.beeete2.android.epoxyexample.ui.view.addHeaderItemView
import com.beeete2.android.epoxyexample.ui.view.addLabeledFieldItemView
import com.beeete2.android.epoxyexample.ui.view.errorItemView
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.fragment_base.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendResultFragment : Fragment() {

    private val TAG by lazy { javaClass.simpleName }

    private val vm: FriendResultViewModel by viewModel()

    private val controller = Controller()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false).apply {
            recycler_view.apply {
                setController(controller)
                addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.hide()

        vm.friend.observe(viewLifecycleOwner) {
            controller.setData(it)
        }
    }

    inner class Controller : TypedEpoxyController<Friend>() {
        override fun buildModels(data: Friend?) {
            if (data != null) {
                addHeaderItemView {
                    id("name_header")
                    header(R.string.name_header)
                }
                addLabeledFieldItemView {
                    id("first_name")
                    label(R.string.first_name_hint)
                    value(data.firstName)
                }
                addLabeledFieldItemView {
                    id("last_name")
                    label(R.string.last_name_hint)
                    value(data.lastName)
                }

                addHeaderItemView {
                    id("phonetic_name_header")
                    header(R.string.phonetic_name_header)
                }
                addLabeledFieldItemView {
                    id("phonetic_first_name")
                    label(R.string.first_name_hint)
                    value(data.phoneticFirstName)
                }
                addLabeledFieldItemView {
                    id("phonetic_last_name")
                    label(R.string.last_name_hint)
                    value(data.phoneticLastName)
                }

                addHeaderItemView {
                    id("gender_header")
                    header(R.string.gender_header)
                }
                addFieldItemView {
                    id("gender")
                    value(data.gender.text)
                }

                addHeaderItemView {
                    id("address_header")
                    header(R.string.address_header)
                }
                addFieldItemView {
                    id("address")
                    value(data.address)
                }

                addHeaderItemView {
                    id("more_header")
                    header(R.string.more_header)
                }
                addLabeledFieldItemView {
                    id("block")
                    label(R.string.block_switch_label)
                    value(data.blockText)
                }
                addLabeledFieldItemView {
                    id("favorite")
                    label(R.string.favorite_switch_label)
                    value(data.favoriteText)
                }
                addLabeledFieldItemView {
                    id("notes")
                    label(R.string.notes_hint)
                    value(data.notes)
                }

            } else {
                errorItemView {
                    id("error")
                }
            }
        }

    }
}
