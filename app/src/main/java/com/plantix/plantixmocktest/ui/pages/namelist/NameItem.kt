package com.plantix.plantixmocktest.ui.pages.namelist

import android.view.View
import com.plantix.plantixmocktest.data.db.entities.Name
import com.plantix.plantixmocktest.databinding.NameItemBinding
import com.plantix.plantixmocktest.extensions.newCapitalize
import com.plantix.plantixmocktest.utils.Layout
import com.xwray.groupie.viewbinding.BindableItem
import java.util.*

class NameItem(private val name: Name) : BindableItem<NameItemBinding>() {

    override fun bind(viewBinding: NameItemBinding, position: Int) {
        viewBinding.tvName.text = "${name.firstName.newCapitalize()} ${name.lastName.newCapitalize()}"
    }

       override fun getLayout() = Layout.name_item

    override fun initializeViewBinding(view: View): NameItemBinding {
        return NameItemBinding.bind(view)
    }
}