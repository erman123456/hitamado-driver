package pt.lunata.hitamado.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.data.remote.RemoteDataSource
import pt.lunata.hitamado.data.remote.page.OperationalPageDataSource
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideSjtRepository(remoteDataSource: RemoteDataSource): SjtRepository =
        SjtRepository(remoteDataSource)

    @Provides
    fun provideRemoteDataSource(): RemoteDataSource = RemoteDataSource()

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    fun provideOperationalPageDataSource(
        remoteDataSource: RemoteDataSource,
        context: Context
    ): OperationalPageDataSource = OperationalPageDataSource(remoteDataSource, context)
}