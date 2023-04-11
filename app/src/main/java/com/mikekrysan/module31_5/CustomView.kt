package com.mikekrysan.module31_5

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CustomView@JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) : View(context, attributeSet) {


    private var strokePaint = Paint().apply {
        color = Color.parseColor("#FF018786")   //что то здесь с цветом не так!
        style = Paint.Style.STROKE
        strokeWidth = 5f
        flags = Paint.ANTI_ALIAS_FLAG
    }

    private var textPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 5f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //Считаем полный размер с паддингами
        val heightSize = MeasureSpec.getSize(heightMeasureSpec) + paddingBottom + paddingTop
        val widthSize = MeasureSpec.getSize(widthMeasureSpec) + paddingLeft + paddingRight
        //Получаем конечные размеры View, с учетом режима
        val resolvedWidth = resolveSize(widthSize, widthMeasureSpec)
        val resolvedHeight = resolveSize(heightSize, heightMeasureSpec)
        //Устанавливаем итоговые размеры
        setMeasuredDimension(resolvedWidth, resolvedHeight)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

    }


    override fun onDraw(canvas: Canvas) {
//        canvas.drawColor(Color.MAGENTA) //нарисует квадрат пурпурного цвета
//        canvas.drawPoint(width / 2f, height / 2f, paint)    //нарисует точку на экране в центре
//        canvas.drawLine(0f,0f, width.toFloat(), height.toFloat(), paint)    //нарисует линию на экране
//        canvas.drawLine(width.toFloat(),0f, 0f, height.toFloat(), paint)    //вторая линия на экране
//        canvas.drawCircle(width / 2f, height / 2f, 100f, paint) //рисуем круг
//        canvas.drawRect(100f, 100f, 300f, 300f, paint)  //рисует квадрат

        //Рисуем треугольник произвольной формы:
        //Создаем точки при помощи объекта Point
//        val a = Point(0, 0)
//        val b = Point(0, 100)
//        val c = Point(87, 50)
//
//        //Создаем объект Path
//        val path = Path()
//        //Указываем, как он будет заполняться краской
//        path.fillType = Path.FillType.EVEN_ODD
//        //Рисуем путь по точкам, созданным ранее
//        path.lineTo(b.x.toFloat(), b.y.toFloat())
//        path.lineTo(c.x.toFloat(), c.y.toFloat())
//        path.lineTo(a.x.toFloat(), a.y.toFloat())
//        //"Замыкаем" путь
//        path.close()
//        //Рисуем на канвасе
//        canvas.drawPath(path, paint)

        //Работаем с текстом:
//        canvas.drawText("Text", width / 2f, height / 2f, textPaint) //Рисуется просто прямой тект

        //Для того, чтобы нарисовать пользовательский текст, нужно указать путь:
        val path = Path()
        path.addCircle(width / 2f, height / 2f, 400f, Path.Direction.CW)
        canvas.drawCircle(width / 2f, height / 2f, 400f, strokePaint)
        canvas.drawTextOnPath("TextTextText", path, 0f, 0f, textPaint)


    }

    private var paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 5f
    }



}