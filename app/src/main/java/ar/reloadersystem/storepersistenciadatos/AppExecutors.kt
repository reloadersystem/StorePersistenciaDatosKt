package ar.reloadersystem.storepersistenciadatos

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors(
    val diskIO: Executor = Executors.newSingleThreadExecutor(),
    val networkIO: Executor = Executors.newFixedThreadPool(THREAD_COUNT),
    val mainThread: Executor =
        MainThreadExecutor()
) {
    companion object {
        const val THREAD_COUNT: Int = 3
    }


    internal class MainThreadExecutor : Executor {

        private val mainThreHandler: Handler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreHandler.post(command)
        }
    }
}

