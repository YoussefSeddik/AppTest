package com.seddik.youssef.graphqlapp

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.item_layout.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class UserLayoutView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0

) : ConstraintLayout(context, attributeSet, defStyle) {
    private val rootLayout: CardView
    private val title_tv: TextView
    private val desc_tv: TextView

    init {
        View.inflate(context, R.layout.item_layout, this)
        rootLayout = findViewById(R.id.itemlayout)
        title_tv = findViewById(R.id.title_tv)
        desc_tv = findViewById(R.id.decs_tv)
    }

    @TextProp
    fun setTitle(title: CharSequence) {
        title_tv.text = title
    }

    @TextProp
    fun setDesc(desc: CharSequence) {
        decs_tv.text = desc
    }
}