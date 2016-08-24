package com.example.heyehui.heyehui_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        // TODO Auto-generated constructor stub
    }

    public MyView(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    private void init() {
        paint = new Paint();

        // 设置笔的颜色
        paint.setColor(0xffff0000);
        // 设置笔的粗细,在java代码中指定的值都是像素px
        paint.setStrokeWidth(3);

        // 设置画笔描边
        paint.setStyle(Style.STROKE);

        // 设置反锯齿
        paint.setAntiAlias(true);

        // 构造方法来定义一个圆或者椭圆的矩形区域
        rectF = new RectF(20, 20, 320, 220);

        // 预览的时候，getResource是无法拿到的
        bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher);
    }

    // 画笔
    private Paint paint = null;

    // rectf
    private RectF rectF = null;

    // bitmap
    private Bitmap bitmap = null;

    // 绘制view的方法
    // 把这个控件画出来，
    // canvas是画布，可以理解为屏幕上的一块
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        /**
         *  ondraw为系统调用的方法，这里建议不要new对象
         paint=new Paint();
         getHeight是得到这个控件的高度
         getWidth是得到这个控件的宽度
         指定五个参数，分别是开始的点的坐标，结束的点的坐标，和画笔
         * */
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);

    }

}
