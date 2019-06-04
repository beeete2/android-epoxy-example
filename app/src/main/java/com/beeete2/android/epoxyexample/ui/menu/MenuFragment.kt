package com.beeete2.android.epoxyexample.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.beeete2.android.epoxyexample.R
import com.beeete2.android.epoxyexample.ext.navigate
import com.beeete2.android.epoxyexample.ui.view.menuItemView
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.fragment_base.view.*

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false).apply {
            recycler_view.apply {
                addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
                withModels {
                    menuItemView {
                        id("friend")
                        text(R.string.menu_friend)
                        clickListener { _ ->
                            navigate(R.id.friendListFragment)
                        }
                    }
                    menuItemView {
                        id("switcher")
                        text(R.string.menu_switcher)
                        clickListener { _ ->
                            navigate(R.id.switcherFragment)
                        }
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.hide()
    }

}
