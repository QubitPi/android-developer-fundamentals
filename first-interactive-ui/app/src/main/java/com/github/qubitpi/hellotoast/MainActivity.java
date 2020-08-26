/*
 * Copyright 刘珈奇
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.qubitpi.hellotoast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * An Android activity is both a unit of user interaction - typically filling the whole screen of an Android mobil
 * device - and a unit of execution.
 * <p>
 * When you make an interactive Android program, you start by subclassing the {@link Activity} class. Activities provide
 * the reusable, interchangeable parts of the flow of UI components across Android applications.
 * <p>
 * When the system starts this activity it calls the constructor for {@link MainActivity}, a subclass of
 * {@link Activity}, and then calls its {@link Activity#onCreate(Bundle)}. This causes the view hierarchy described in
 * the {@code activity_main.xml} to load and display. The {@link Activity#onCreate(Bundle)} method kicks off the life
 * cycle of the {@link Activity}.
 * <p>
 * The {@link Activity} class is one of the most important classes in the Android system, promoting app's modularity and
 * allowing functionality to be shared. An activity interacts with the Android runtime to implement key aspects of the
 * application life cycle. Each activity can also be independently configured,, through a {@link Context} class.
 * <p>
 * Each activity in an Android application is largely separate from other activities. The code that implements one
 * activity does not directly call methods in the code that implements another activity. Other elements in the Android
 * Framework - usually the {@link Intent}, are used to manage communications instead. It is strongly discouraged from
 * keeping references to {@link Activity} objects. The Android Runtime Environment, which creates and manages activities
 * and other application components, often reclaims the memory they use to restrict individual tasks to relatively small
 * amount of memory.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Keep track of the count.
     * <p>
     * Each tap of the <b>Count</b> button increases the value of this variable.
     */
    private final AtomicInteger count = new AtomicInteger(0);

    /**
     * A reference to the {@code show_count} TextView.
     */
    private TextView showCount;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = findViewById(R.id.show_count);
    }

    /**
     * The <b>Toast</b> {@code Button} click handler, which shows a message.
     * <p>
     * A <a href="https://developer.android.com/reference/android/widget/Toast.html">Toast</a> provides a way to show a
     * simple message in a small popup window. It fills only the amount of space required for the message. The current
     * activity remains visible and interactive. A {@code Toast} can be useful for testing interactivity in an app - add
     * a {@code Toast} message to show the result of tapping a {@code Button} or performing an action.
     * <p>
     * The duration of the {@code Toast} display is set to {@link Toast#LENGTH_SHORT}
     * (choosen from {@link Toast#LENGTH_LONG} and {@link Toast#LENGTH_LONG}). The actual lengths are about 3.5 seconds
     * for the long {@code Toast} and 2 seconds for the short {@code Toast}
     *
     * @param view  The {@code View} on which the {@code Toast} is to be shown.
     */
    public void showToast(final View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    /**
     * The <b>Count</b> {@code Button} click handler that displays the current count after <b>Count</b> is tapped; each
     * tap increases the count by one.
     * <p>
     * The handler
     * <ul>
     *     <li> Keep track of the count as it changes
     *     <li> Send the updated count to the {@code TextView} to display it.
     * </ul>
     *
     * @param view  The {@code view} that displays the count
     */
    @SuppressLint("SetTextI18n")
    public void countUp(final View view) {
        count.incrementAndGet();
        if (showCount != null) {
            showCount.setText(count.toString());
        }
    }
}
