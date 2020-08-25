package ph.com.browse.jobs.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = ViewModelProviders.of(this, factory).get(getViewModel())
    }

    fun showMessage(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }

    fun showError(view: View, throwable: Throwable) {
        when (throwable) {
            is HttpException -> {
//                showMessage(view, getString(R.string.network_connection_required))
            }
            is UnknownHostException -> {
//                showMessage(view, getString(R.string.network_connection_required))
            }
        }
    }

}