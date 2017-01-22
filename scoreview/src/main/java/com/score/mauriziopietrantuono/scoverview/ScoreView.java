package com.score.mauriziopietrantuono.scoverview;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import icepick.Icepick;
import icepick.State;


public class ScoreView extends View {
    // Constants
    private static final float MAX_SCORE = 700;
    // Score
    @State int score;

    // Paints
    private Paint innerCirclePaint;
    private Paint outerCirclePaint;
    private TextPaint scoreTextPaint;
    private TextPaint uperAndLowerTextPaint;

    // Dimensions
    @State int outerCircleStroke;
    @State int circlesPadding;
    @State int innercCircleStroke;
    @State int upperAndLowerTextSize;
    @State int scoreTextSize;
    @State int textSpacing;

    // Text
    @State String upperText;
    @State String lowerText;

    // Colors
    @State int outerCircleColor;
    @State int upperAndLowerTextColor;
    @State int startColor;
    @State int endColor;
    @State int middleColor;

    // RectF
    private RectF innerCircleOval;

    public ScoreView(Context context) {
        this(context, null);
    }

    public ScoreView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ScoreView, defStyleAttr, 0);
        loadAttributes(attributes);
        attributes.recycle();
        init();
    }

    private void loadAttributes(TypedArray attributes) {
        Context context = getContext();
        Resources resources = context.getResources();
        outerCircleStroke = attributes.getDimensionPixelSize(R.styleable.ScoreView_outer_circle_stroke, resources.getDimensionPixelSize(R.dimen.defaultOuterCircleStroke));
        outerCircleColor = attributes.getColor(R.styleable.ScoreView_outer_circle_color, ContextCompat.getColor(context, R.color.defaultOuterCircleColor));
        scoreTextSize = attributes.getDimensionPixelSize(R.styleable.ScoreView_score_text_size, resources.getDimensionPixelSize(R.dimen.defaultScoreTextSize));
        innercCircleStroke = attributes.getDimensionPixelSize(R.styleable.ScoreView_inner_circle_stroke, resources.getDimensionPixelSize(R.dimen.defaultInnercCircleStroke));
        circlesPadding = attributes.getDimensionPixelSize(R.styleable.ScoreView_circles_padding, resources.getDimensionPixelSize(R.dimen.defaultCirclesPadding));
        startColor = attributes.getColor(R.styleable.ScoreView_start_color, ContextCompat.getColor(context, R.color.defaultStartColor));
        middleColor = attributes.getColor(R.styleable.ScoreView_middle_color, ContextCompat.getColor(context, R.color.defaulMiddleColor));
        endColor = attributes.getColor(R.styleable.ScoreView_end_color, ContextCompat.getColor(context, R.color.defaultEndColor));
        upperAndLowerTextSize = attributes.getDimensionPixelSize(R.styleable.ScoreView_upper_and_lower_text_size, resources.getDimensionPixelSize(R.dimen.defaultUpperAndLowerTextSize));
        upperAndLowerTextColor = attributes.getColor(R.styleable.ScoreView_upper_and_lower_text_color, ContextCompat.getColor(context, R.color.defaultOuterCircleColor));

        if (attributes.getString(R.styleable.ScoreView_upper_text) != null) {
            upperText = attributes.getString(R.styleable.ScoreView_upper_text);
        } else {
            upperText = resources.getString(R.string.default_upper_text);
        }
        if (attributes.getString(R.styleable.ScoreView_lower_text) != null) {
            lowerText = attributes.getString(R.styleable.ScoreView_lower_text);
        } else {
            lowerText = resources.getString(R.string.default_lower_text);
        }
        textSpacing = attributes.getDimensionPixelSize(R.styleable.ScoreView_text_spacing, resources.getDimensionPixelSize(R.dimen.defaultTextSpacing));
    }

    private void init() {
        innerCircleOval = new RectF();

        outerCirclePaint = new Paint();
        outerCirclePaint.setAntiAlias(true);
        outerCirclePaint.setStrokeWidth(getOuterCircleStroke());
        outerCirclePaint.setColor(getOuterCircleColor());
        outerCirclePaint.setStyle(Paint.Style.STROKE);

        scoreTextPaint = new TextPaint();
        scoreTextPaint.setTextSize(getScoreTextSize());
        scoreTextPaint.setAntiAlias(true);

        innerCirclePaint = new Paint();
        innerCirclePaint.setAntiAlias(true);
        innerCirclePaint.setStrokeWidth(getInnercCircleStroke());
        innerCirclePaint.setStyle(Paint.Style.STROKE);
        innerCirclePaint.setStrokeCap(Paint.Cap.ROUND);

        uperAndLowerTextPaint = new TextPaint();
        uperAndLowerTextPaint.setColor(getUpperAndLowerTextColor());
        uperAndLowerTextPaint.setTextSize(getUpperAndLowerTextSize());
        uperAndLowerTextPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int size;
        if (width > height) {
            size = height;
        } else {
            size = width;
        }
        calulateInnerCircleOval(size);
        setMeasuredDimension(size, size);
    }

    private void calulateInnerCircleOval(int size) {
        int margin = getOuterCircleStroke() + getCirclesPadding() + getInnercCircleStroke() / 2;
        innerCircleOval.top = margin;
        innerCircleOval.left = margin;
        innerCircleOval.bottom = size - margin;
        innerCircleOval.right = size - margin;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawOuterCircle(canvas);
        drawInnerCircleAndScore(canvas, getScore());
        drawUpperText(canvas);
        drawLowerText(canvas);
    }

    private void drawUpperText(Canvas canvas) {
        if (TextUtils.isEmpty(getUpperText())) {
            return;
        }
        float y = ((getMeasuredHeight()) - getScoreTextHeight()) / 2 - getTextSpacing();
        float x = (getMeasuredWidth() - uperAndLowerTextPaint.measureText(getUpperText())) / 2.0f;
        canvas.drawText(getUpperText(), x, y, uperAndLowerTextPaint);
    }

    private void drawLowerText(Canvas canvas) {
        if (TextUtils.isEmpty(getLowerText())) {
            return;
        }
        float textHeight = getUpperAndLowerTextHeight();
        float y = (getMeasuredHeight() + getScoreTextHeight()) / 2 + textHeight + getTextSpacing();
        float x = (getMeasuredWidth() - uperAndLowerTextPaint.measureText(getLowerText())) / 2.0f;
        canvas.drawText(getLowerText(), x, y, uperAndLowerTextPaint);
    }

    private float getUpperAndLowerTextHeight() {
        return -(uperAndLowerTextPaint.descent() + uperAndLowerTextPaint.ascent());
    }

    private void drawScoreText(Canvas canvas, float angle) {
        if (getScoreText() == null) {
            return;
        }
        scoreTextPaint.setColor(calculateColor(angle));
        float textHeight = getScoreTextHeight();
        float x = (getMeasuredWidth() - scoreTextPaint.measureText(getScoreText())) / 2.0f;
        float y = (getMeasuredHeight() + textHeight) / 2.0f;
        canvas.drawText(getScoreText(), x, y, scoreTextPaint);
    }

    private float getScoreTextHeight() {
        return -(scoreTextPaint.descent() + scoreTextPaint.ascent());
    }

    private void drawOuterCircle(Canvas canvas) {
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, calculateOuterCircleRadius(), getOuterCirclePaint());
    }

    private float calculateOuterCircleRadius() {
        return getMeasuredWidth() / 2 - getOuterCircleStroke();
    }

    private void drawInnerCircleAndScore(Canvas canvas, int score) {
        if (score == 0) {
            return;
        }
        float degrees = calculateDegrees(score);
        float startAngle = (float) -Math.toDegrees(Math.PI / 2);
        double endAngle = degrees - Math.toDegrees(Math.PI / 2);

        for (float angle = startAngle; angle <= endAngle; angle++) {
            canvas.drawArc(innerCircleOval, angle, 1, false, getInnerCirlePaint(angle));
            drawScoreText(canvas, angle);
        }
    }

    private Paint getInnerCirlePaint(float angle) {
        innerCirclePaint.setColor(calculateColor(angle));
        return innerCirclePaint;
    }

    private int calculateColor(float angle) {
        angle += Math.toDegrees(Math.PI / 2);
        float fraction = (float) (angle / Math.toDegrees(Math.PI));
        if (angle <= Math.toDegrees(Math.PI)) {
            return (int) new ArgbEvaluator().evaluate(fraction, getStartColor(), getMiddleColor());
        } else {
            return (int) new ArgbEvaluator().evaluate(fraction, getMiddleColor(), getEndColor());
        }
    }

    private float calculateDegrees(int score) {
        return (float) ((score / MAX_SCORE) * Math.toDegrees(2 * Math.PI));
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return Icepick.saveInstanceState(this, super.onSaveInstanceState());

    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(Icepick.restoreInstanceState(this, state));
    }

    private int getOuterCircleStroke() {
        return outerCircleStroke;
    }

    public void setOuterCircleStroke(int outerCircleStroke) {
        this.outerCircleStroke = outerCircleStroke;
        invalidate();
    }

    private int getCirclesPadding() {
        return circlesPadding;
    }

    public void setCirclesPadding(int circlesPadding) {
        this.circlesPadding = circlesPadding;
        invalidate();
    }

    private int getInnercCircleStroke() {
        return innercCircleStroke;
    }

    public void setInnercCircleStroke(int innercCircleStroke) {
        this.innercCircleStroke = innercCircleStroke;
        invalidate();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        invalidate();
    }

    private Paint getOuterCirclePaint() {
        return outerCirclePaint;
    }

    private float getTextSpacing() {
        return textSpacing;
    }

    public void setTextSpacing(int textSpacing) {
        this.textSpacing = textSpacing;
        invalidate();
    }

    private String getUpperText() {
        return upperText;
    }

    private String getLowerText() {
        return lowerText;
    }

    public void setLowerText(String lowerText) {
        this.lowerText = lowerText;
        invalidate();
    }


    public void setUpperText(String upperText) {
        this.upperText = upperText;
        invalidate();
    }

    private String getScoreText() {
        if (getScore() > 0) {
            return Integer.toString(getScore());
        } else {
            return null;
        }
    }

    private int getScoreTextSize() {
        return scoreTextSize;
    }

    public void setScoreTextSize(int scoreTextSize) {
        this.scoreTextSize = scoreTextSize;
        invalidate();
    }

    private int getMiddleColor() {
        return middleColor;
    }

    public void setMiddleColor(int middleColor) {
        this.middleColor = middleColor;
        invalidate();
    }

    private int getEndColor() {
        return endColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
        invalidate();
    }

    private int getStartColor() {
        return startColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
        invalidate();
    }

    private int getUpperAndLowerTextColor() {
        return upperAndLowerTextColor;
    }

    public void setUpperAndLowerTextColor(int upperAndLowerTextColor) {
        this.upperAndLowerTextColor = upperAndLowerTextColor;
        invalidate();
    }

    private int getOuterCircleColor() {
        return outerCircleColor;
    }

    public void setOuterCircleColor(int outerCircleColor) {
        this.outerCircleColor = outerCircleColor;
        invalidate();
    }

    private int getUpperAndLowerTextSize() {
        return upperAndLowerTextSize;
    }

    public void setUpperAndLowerTextSize(int upperAndLowerTextSize) {
        this.upperAndLowerTextSize = upperAndLowerTextSize;
        invalidate();
    }

}