/*
 * Copyright (C) 2008 Romain Guy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.curiouscreature.android.shelves.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.content.Context;
import android.view.View;
import org.curiouscreature.android.shelves.R;

public class SpotlightDrawable extends Drawable {
    private final Bitmap mBitmap;
    private final Paint mPaint;
    private final View mView;

    public SpotlightDrawable(Context context, View view) {
        this(context, view, R.drawable.spotlight);
    }

    public SpotlightDrawable(Context context, View view, int resource) {
        mView = view;
        mBitmap = BitmapFactory.decodeResource(context.getResources(), resource);

        mPaint = new Paint();
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
    }

    public void draw(Canvas canvas) {
        if (mView.hasWindowFocus()) {
            final Rect bounds = getBounds();
            canvas.drawBitmap(mBitmap, bounds.left, bounds.top, mPaint);
        }
    }

    @Override
    protected boolean onStateChange(int[] state) {
        invalidateSelf();
        return super.onStateChange(state);
    }

    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
