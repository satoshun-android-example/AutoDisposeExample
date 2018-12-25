package com.github.satoshun.coroutine.autodispose.view

import android.view.View
import kotlinx.coroutines.Job
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

@Suppress("FunctionName")
fun ViewAutoDispose(view: View): ContinuationInterceptor =
  ViewAutoDisposeImpl(view)

internal class ViewAutoDisposeImpl(
  private val view: View
) : ContinuationInterceptor {
  override val key: CoroutineContext.Key<*>
    get() = ContinuationInterceptor

  override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
    val job = continuation.context[Job]
    if (job != null) {
      view.addJob(job)
    }
    return continuation
  }
}