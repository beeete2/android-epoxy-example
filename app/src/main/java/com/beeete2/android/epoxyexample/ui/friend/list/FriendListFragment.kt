package com.beeete2.android.epoxyexample.ui.friend.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.airbnb.epoxy.TypedEpoxyController
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.ext.navigate
import com.beeete2.android.epoxyexample.ext.text
import com.beeete2.android.epoxyexample.model.entity.Friend
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.fragment_base.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendListFragment : Fragment() {

    private val vm: FriendListViewModel by viewModel()

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

        fab.setImageResource(R.drawable.ic_add)
        fab.setOnClickListener {
            navigate(R.id.friendInputFragment)
        }

        vm.friends.observe(viewLifecycleOwner) {
            controller.setData(it)
        }
    }

    inner class Controller : TypedEpoxyController<List<Friend>>() {
        override fun buildModels(data: List<Friend>?) {
            data ?: return

            data.forEach {
                friendItemView {
                    id(it.id)
                    name("${it.firstName} ${it.lastName}")
                    phonetic("${it.phoneticFirstName} ${it.phoneticLastName}")
                    gender(it.gender.text)
                    clickListener { _ ->
                        Snackbar.make(recycler_view, "clicked", Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

}
