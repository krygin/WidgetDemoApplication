package ru.krygin.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [DemoAppWidgetConfigureActivity]
 */
class DemoAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        Log.e("APP_WIDGET", "onUpdate")
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
//            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("APP_WIDGET", "onReceive: $intent")
        super.onReceive(context, intent)
    }

    override fun onEnabled(context: Context?) {
        Log.e("APP_WIDGET", "onEnabled")
    }

    override fun onDisabled(context: Context?) {
        Log.e("APP_WIDGET", "onDisabled")
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.demo_app_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}