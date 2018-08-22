package in.co.khuranasales.khuranasales;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;

import com.nineoldandroids.view.ViewHelper;

import static in.co.khuranasales.khuranasales.Utils.dpToPx;

public class MaterialViewPagerHeader {

    protected Context context;

    protected View toolbarLayout;
    protected Toolbar toolbar;
    protected View mPagerSlidingTabStrip;

    protected View toolbarLayoutBackground;
    protected View headerBackground;
    protected View statusBackground;
    protected View mLogo;
    public float finalTabsY;
    public float finalTitleY;
    public float finalTitleHeight;
    public float finalTitleX;
    public float originalTitleY;
    public float originalTitleHeight;
    public float originalTitleX;
    public float finalScale;

    private MaterialViewPagerHeader(Toolbar toolbar) {
        this.toolbar = toolbar;
        this.context = toolbar.getContext();
        this.toolbarLayout = (View) toolbar.getParent();
    }

    public static MaterialViewPagerHeader withToolbar(Toolbar toolbar) {
        return new MaterialViewPagerHeader(toolbar);
    }

    public Context getContext() {
        return context;
    }

    public MaterialViewPagerHeader withPagerSlidingTabStrip(View pagerSlidingTabStrip) {
        this.mPagerSlidingTabStrip = pagerSlidingTabStrip;

        mPagerSlidingTabStrip.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                finalTabsY = dpToPx(-2, context);

                mPagerSlidingTabStrip.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });

        return this;
    }

    public MaterialViewPagerHeader withHeaderBackground(View headerBackground) {
        this.headerBackground = headerBackground;
        return this;
    }

    public MaterialViewPagerHeader withStatusBackground(View statusBackground) {
        this.statusBackground = statusBackground;
        return this;
    }

    public MaterialViewPagerHeader withToolbarLayoutBackground(View toolbarLayoutBackground) {
        this.toolbarLayoutBackground = toolbarLayoutBackground;
        return this;
    }

    public MaterialViewPagerHeader withLogo(View logo) {
        this.mLogo = logo;

        toolbarLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                ViewHelper.setTranslationY(mLogo,0);
                ViewHelper.setTranslationX(mLogo, 0);

                originalTitleY = ViewHelper.getY(mLogo);
                originalTitleX = ViewHelper.getX(mLogo);

                originalTitleHeight = mLogo.getHeight();
                finalTitleHeight = dpToPx(21, context);
                finalScale = finalTitleHeight / originalTitleHeight;

                finalTitleY = (toolbar.getPaddingTop() + toolbar.getHeight()) / 2 - finalTitleHeight / 2 - (1 - finalScale) * finalTitleHeight;
                finalTitleX = dpToPx(52f, context) - (mLogo.getWidth() / 2) * (1 - finalScale);

                toolbarLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });
        return this;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public View getHeaderBackground() {
        return headerBackground;
    }

    public View getStatusBackground() {
        return statusBackground;
    }

    public View getLogo() {
        return mLogo;
    }

}
