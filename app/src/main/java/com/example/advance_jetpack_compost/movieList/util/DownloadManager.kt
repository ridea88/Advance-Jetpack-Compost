package com.example.advance_jetpack_compost.movieList.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.advance_jetpack_compost.R
import kotlinx.coroutines.delay

class DownloadManager (
    appContext: Context, downloads: WorkerParameters) : CoroutineWorker(appContext, downloads
)
{
    override suspend fun doWork(): Result {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "download_channel"
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Download", NotificationManager.IMPORTANCE_LOW)
            notificationManager.createNotificationChannel(channel)
        }

        val notificationBuilder = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle("Downloading")
            .setSmallIcon(R.drawable.img)
            .setPriority(NotificationCompat.PRIORITY_LOW)

        for (progress in 1..100 step 10) {
            notificationBuilder.setProgress(100, progress, false)
            notificationManager.notify(1, notificationBuilder.build())
            delay(500)
        }

        notificationBuilder.setContentText("Download complete")
            .setProgress(0, 0, false)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        notificationBuilder.setSound(defaultSoundUri)

        notificationManager.notify(1, notificationBuilder.build())

        return Result.success()
    }
}
