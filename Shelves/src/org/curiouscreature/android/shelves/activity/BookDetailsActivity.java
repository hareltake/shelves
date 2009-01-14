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

package org.curiouscreature.android.shelves.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import org.curiouscreature.android.shelves.provider.BooksStore;
import org.curiouscreature.android.shelves.provider.BooksManager;
import org.curiouscreature.android.shelves.R;

public class BookDetailsActivity extends Activity {
    private static final String EXTRA_BOOK = "shelves.extra.book_id";

    private BooksStore.Book mBook;
//    private WebView mDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBook = getBook();
        if (mBook == null) finish();

        setContentView(R.layout.screen_bookdetails);
        setupViews();
    }

    private BooksStore.Book getBook() {
        final Intent intent = getIntent();
        if (intent != null) {
            final String bookId = intent.getStringExtra(EXTRA_BOOK);
            if (bookId != null) {
                return BooksManager.findBook(getContentResolver(), bookId);
            }
        }
        return null;
    }

    private void setupViews() {
//        final WebView details = mDetails = (WebView) findViewById(R.id.webview_details);
//        details.setBackgroundColor(0);
//        details.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//
//        final WebSettings webSettings = details.getSettings();
//        webSettings.setSavePassword(false);
//        webSettings.setSaveFormData(false);
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setSupportZoom(false);
//        webSettings.setBlockNetworkImage(true);
    }

    static void show(Context context, String bookId) {
        final Intent intent = new Intent(context, BookDetailsActivity.class);
        intent.putExtra(EXTRA_BOOK, bookId);
        context.startActivity(intent);
    }
}
