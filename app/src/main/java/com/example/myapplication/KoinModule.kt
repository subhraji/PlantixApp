
import com.example.myapplication.model.repository.about_canada.AboutCanadaRepository
import com.example.myapplication.model.repository.about_canada.AboutCanadaRepositoryImpl
import com.example.myapplication.viewmodel.AboutCanadaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AboutCanadaRepository> { AboutCanadaRepositoryImpl(get()) }
    viewModel { AboutCanadaViewModel(get()) }
}