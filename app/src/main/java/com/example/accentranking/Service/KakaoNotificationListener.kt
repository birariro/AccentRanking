package com.example.accentranking.Service

import android.app.Notification
import android.graphics.drawable.Icon
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class KakaoNotificationListener : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        val packageName = sbn.packageName
        if (!TextUtils.isEmpty(packageName) && packageName == "com.kakao.talk") {
            // 알람 확인
            Toast.makeText(this, "테스트1", Toast.LENGTH_SHORT).show()
            val extras = sbn.notification.extras
            val title = extras.getString(Notification.EXTRA_TITLE)
            val text = extras.getCharSequence(Notification.EXTRA_TEXT)
            val subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT)
            if(title !="null" && text != "null")
            {
                Log.d("TAG", "onNotificationPosted: 이름 $title")
                Log.d("TAG", "onNotificationPosted: 메시지 :$text")
                Log.d("TAG", "onNotificationPosted: 채팅방 이름:$subText")
            }


         /*   id null
            text : null
            subText:445개의 안 읽은 메시지*/
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        // 알람 미확인
        Toast.makeText(this, "테스트2", Toast.LENGTH_SHORT).show()
    }
}