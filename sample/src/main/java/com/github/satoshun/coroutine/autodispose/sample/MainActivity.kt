package com.github.satoshun.coroutine.autodispose.sample

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.satoshun.coroutine.autodispose.lifecycle.autoDisposeScope
import com.github.satoshun.coroutine.autodispose.view.autoDisposeScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity () {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    // auto dispose when onDestroy
    val childJob = autoDisposeScope.launch {
      while (true) {
        delay(1000)
        Log.d("MainActivity", "onCreate loop")
      }
    }
    childJob.invokeOnCompletion {
      Log.d("MainActivity", "onCreate completed")
    }

    supportFragmentManager.commit {
      add(R.id.frame, MainFragment())
    }

    findViewById<ViewGroup>(R.id.root).addView(MainView(this))

    val recycler = findViewById<RecyclerView>(R.id.recycler)
    recycler.adapter = SampleAdapter()
    recycler.layoutManager = LinearLayoutManager(this)
  }

  override fun onResume() {
    super.onResume()
    // auto dispose when onPause
    val childJob = autoDisposeScope.launch {
      while (true) {
        delay(3000)
        Log.d("MainActivity", "onResume loop")
      }
    }
    childJob.invokeOnCompletion {
      Log.d("MainActivity", "onResume completed")
    }
  }
}

internal class SampleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
    object : RecyclerView.ViewHolder(
      TextView(parent.context)
    ) {}

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    (holder.itemView as TextView).text = position.toString()

    val job = holder.itemView.autoDisposeScope.launch {
      delay(3000)
      Log.d("RecyclerView", "success $position")
    }
    job.invokeOnCompletion {
      Log.d("RecyclerView", "complete $position")
    }
  }

  override fun getItemCount(): Int = 1000
}
