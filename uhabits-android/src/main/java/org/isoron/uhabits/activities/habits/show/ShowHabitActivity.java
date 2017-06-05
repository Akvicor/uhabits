/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.activities.habits.show;

import android.os.*;
import android.support.annotation.*;

import org.isoron.uhabits.activities.*;

/**
 * Activity that allows the user to see more information about a single habit.
 * <p>
 * Shows all the metadata for the habit, in addition to several charts.
 */
public class ShowHabitActivity extends HabitsActivity
{

    @Nullable
    private ShowHabitScreen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        HabitsActivityComponent component = getActivityComponent();
        screen = component.getShowHabitScreen();
        screen.setMenu(component.getShowHabitMenu());
        screen.setController(component.getShowHabitController());
        component
            .getShowHabitRootView()
            .setController(component.getShowHabitController());
        setScreen(screen);
    }

    @Override
    protected void onResume()
    {
        if (screen == null) throw new IllegalStateException();
        super.onResume();
        screen.reattachDialogs();
    }
}