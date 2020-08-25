package ph.com.browse.jobs.di.builders

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ph.com.browse.jobs.di.factory.ViewModelFactory

@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(LandingViewModel::class)
//    abstract fun bindLandingViewModel(viewModel: LandingViewModel): ViewModel

}