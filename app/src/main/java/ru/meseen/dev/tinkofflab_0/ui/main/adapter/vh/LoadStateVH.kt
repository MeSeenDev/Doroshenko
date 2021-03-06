package ru.meseen.dev.tinkofflab_0.ui.main.adapter.vh

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import ru.meseen.dev.tinkofflab_0.R

class LoadStateVH(itemView: View, private val retryCallback: () -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
    private val errorDescription: MaterialTextView = itemView.findViewById(R.id.errorTextView)
    private val retryBtn: MaterialButton = itemView.findViewById<MaterialButton>(R.id.retryBtn)
        .also {
            it.setOnClickListener { retryCallback() }
        }


    fun bind(loadState: LoadState) {
        Log.d("TAG", "LoadState: ${(loadState as? LoadState.Error)?.error}")

        progressBar.isVisible = loadState is LoadState.Loading
        ///retryBtn.isVisible = loadState is Error
        errorDescription.isVisible =
            !(loadState as? LoadState.Error)?.error?.message.isNullOrBlank()
        errorDescription.text = (loadState as? LoadState.Error)?.error?.message


    }


}