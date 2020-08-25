package ph.com.browse.jobs.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ph.com.browse.jobs.JobsApplication
import ph.com.browse.jobs.di.builders.ActivityBuilder
import ph.com.browse.jobs.di.builders.ViewModelBuilder
import ph.com.browse.jobs.di.modules.ApplicationModule
import ph.com.browse.jobs.di.modules.NetworkModule
import ph.com.browse.jobs.di.modules.StorageModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        StorageModule::class,
        NetworkModule::class,
        ActivityBuilder::class,
        ViewModelBuilder::class
    ]
)
interface ApplicationComponent {

    fun inject(application: JobsApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent

    }

}