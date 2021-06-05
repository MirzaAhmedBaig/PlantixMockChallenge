package com.plantix.plantixmocktest.ui.pages.namelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.plantix.plantixmocktest.R
import com.plantix.plantixmocktest.data.db.entities.Name
import com.plantix.plantixmocktest.databinding.ActivityNameListBinding
import com.plantix.plantixmocktest.ui.base.BaseVMActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NameListActivity : BaseVMActivity<NameListViewModel, ActivityNameListBinding>() {
    override fun getViewBinding(): ActivityNameListBinding {
        return ActivityNameListBinding.inflate(layoutInflater)
    }

    override fun getClassName(): String {
        return NameListActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeRemoteNames()
        observeNames()
    }

    private fun observeNames() {
        viewModel.getLocalNames().observe(this, Observer {
            if (!it.isNullOrEmpty())
                loadNameList(it)
            else
                viewModel.getRemoteNames()
        })
    }

    private fun observeRemoteNames() {
        viewModel.nameResponse.observe(this, Observer {
            it.checkResponse(onSuccess = {
                it.value.takeIf { !it.isNullOrEmpty() }?.let {
                    viewModel.saveNames(it)
                } ?: Toast.makeText(
                    this@NameListActivity,
                    "Empty Names received",
                    Toast.LENGTH_SHORT
                ).show()
            }, onError = {
                binding.pbLoader.visibility = View.GONE
                handleError(it)
            })
        })
    }


    private fun loadNameList(nameList: List<Name>) {
        Log.d(TAG, "loadNameList : Size : ${nameList.size}\nData : $nameList")
        val mAdapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(nameList.map { NameItem(it) })
        }

        binding.rvNames.apply {
            layoutManager = LinearLayoutManager(this@NameListActivity)
            adapter = mAdapter
        }
        binding.pbLoader.visibility = View.GONE
    }
}