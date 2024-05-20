package com.duytran.chartview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class ChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
):  View(context, attrs, defStyle){

    private val barPaint = Paint()
    private val textPaint = Paint()
    private val barWidth = 120
    private val barSpacing = 100
    private var chartData = listOf(25, 45,25, 5)

    private val labels = listOf("Không khí", "Hạt khoáng", "Nước", "Chất hữu cơ")



    init {
        barPaint.color = ContextCompat.getColor(context, R.color.barPaintColor)
        textPaint.textSize = 35F
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        if (chartData.isEmpty()) {
            return
        }

        val maxHeight = chartData.maxOrNull() ?: 0

        var startX = paddingStart

        for ((index, data) in chartData.withIndex()) {
            val left = startX
            val top = height - paddingBottom - (data * (height - paddingTop - paddingBottom) / maxHeight)
            val right = left + barWidth
            val bottom = height - paddingBottom
            canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), barPaint)

            // Hien thi labels
            val text = labels.getOrNull(index)
            if (text != null) {
                val textWidth = textPaint.measureText(text)
                val textX = left + (barWidth - textWidth) / 2
                val textY = bottom + 35
                canvas.drawText(text, textX, textY.toFloat(), textPaint)
            }

            startX += barWidth + barSpacing
        }
    }
}

