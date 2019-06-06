package com.beeete2.android.epoxyexample.ui.switcher

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.airbnb.epoxy.TypedEpoxyController
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.beeete2.android.epoxyexample.ui.view.addSwitchItem
import com.beeete2.android.epoxyexample.ui.view.addSwitchValueItem
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.fragment_base.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SwitcherFragment : Fragment() {

    private val vm: SwitcherViewModel by viewModel()

    private val controller = Controller()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false).apply {
            recycler_view.apply {
                addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
                setController(controller)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.hide()

        vm.friend.observe(viewLifecycleOwner) {
            controller.setData(it)
        }

        vm.toast.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }

    }

    inner class Controller : TypedEpoxyController<Friend>() {
        override fun buildModels(data: Friend?) {
            data ?: return

            Log.i("SwitcherFragment", "data changed $currentData")

            addSwitchItem {
                id("block")
                label(R.string.block_switch_label)
                checked(data.block)
                checkedChangeListener { _, isChecked ->
                    vm.setBlock(isChecked)
                }
            }
            addSwitchValueItem {
                id("favorite")
                label(R.string.favorite_switch_label)
                checked(SwitchValue(data.favorite))
                checkedChangeListener { _, isChecked ->
                    vm.setFavorite(isChecked)
                }
            }
        }
    }

    data class SwitchValue(val checked: Boolean, private val timestamp: Long = System.currentTimeMillis())

}
