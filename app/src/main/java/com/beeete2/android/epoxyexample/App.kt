package com.beeete2.android.epoxyexample

import android.app.Application
import com.beeete2.android.epoxyexample.model.repository.FriendRepository
import com.beeete2.android.epoxyexample.model.repository.memory.MemoryFriendRepository
import com.beeete2.android.epoxyexample.ui.friend.input.FriendHolder
import com.beeete2.android.epoxyexample.ui.friend.input.FriendInputViewModel
import com.beeete2.android.epoxyexample.ui.friend.list.FriendListViewModel
import com.beeete2.android.epoxyexample.ui.friend.result.FriendResultViewModel
import com.beeete2.android.epoxyexample.ui.switcher.SwitcherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    repositoryModule,
                    uiModule
                )
            )
        }
    }

    private val repositoryModule: Module = module {
        single { MemoryFriendRepository() as FriendRepository }
    }

    private val uiModule: Module = module {
        single { FriendHolder() }
        viewModel { FriendListViewModel(get()) }
        viewModel { FriendInputViewModel(get()) }
        viewModel { FriendResultViewModel(get()) }
        viewModel { SwitcherViewModel() }
    }

}
