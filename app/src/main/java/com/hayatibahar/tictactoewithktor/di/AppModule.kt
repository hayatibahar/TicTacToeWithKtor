package com.hayatibahar.tictactoewithktor.di

import com.hayatibahar.tictactoewithktor.data.KtorRealTimeMessagingClient
import com.hayatibahar.tictactoewithktor.data.RealTimeMessagingClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging)
            install(WebSockets)
        }
    }


    @Provides
    @Singleton
    fun provideRealTimeMessagingClient(httpClient: HttpClient): RealTimeMessagingClient {
        return KtorRealTimeMessagingClient(httpClient)
    }
}