/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.plantix.plantixmocktest.ui.pages.namelist

import android.view.View
import com.plantix.plantixmocktest.data.db.entities.Name
import com.plantix.plantixmocktest.databinding.NameItemBinding
import com.plantix.plantixmocktest.extensions.newCapitalize
import com.plantix.plantixmocktest.utils.Layout
import com.xwray.groupie.viewbinding.BindableItem

class NameItem(private val name: Name) : BindableItem<NameItemBinding>() {

    override fun bind(viewBinding: NameItemBinding, position: Int) {
        viewBinding.tvName.text = "${name.firstName.newCapitalize()} ${name.lastName.newCapitalize()}"
    }

    override fun getLayout() = Layout.name_item

    override fun initializeViewBinding(view: View): NameItemBinding {
        return NameItemBinding.bind(view)
    }
}
