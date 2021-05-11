package com.github.satoshun.coroutine.autodispose.view

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.satoshun.coroutine.autodispose.lifecycle.AutoDisposeScopeTestActivity
import com.github.satoshun.coroutine.autodispose.lifecycle.JobSubject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewJobTest {
    @get:Rule
    val scenarioRule = ActivityScenarioRule(AutoDisposeScopeTestActivity::class.java)

    @Test
    fun addJob_detached() {
        val job = GlobalScope.launch { delay(10000) }
        val scenario = scenarioRule.scenario

        var view: View? = null
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.onActivity {
            view = TextView(it)
            it.setContentView(view)

            view!!.autoDispose(job)
        }
        JobSubject.assertThat(job).isNotCanceled()

        scenario.onActivity {
            // detach view
            it.findViewById<ViewGroup>(android.R.id.content).removeView(view)
        }
        JobSubject.assertThat(job).isCanceled()
    }

    @Test
    fun addJob_cancel() {
        val job = GlobalScope.launch { delay(10000) }
        val scenario = scenarioRule.scenario

        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.onActivity {
            val view = TextView(it)
            it.setContentView(view)

            view.autoDispose(job)
        }
        JobSubject.assertThat(job).isNotCanceled()

        job.cancel()
        JobSubject.assertThat(job).isCanceled()

        // todo check is called View.removeOnAttachStateChangeListener
    }
}
