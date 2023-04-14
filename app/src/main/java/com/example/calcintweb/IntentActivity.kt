package com.example.calcintweb

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var sms:Button
    lateinit var call:Button
    lateinit var share:Button
    lateinit var dial:Button
    lateinit var mpesa:Button
    lateinit var camera:Button
    lateinit var email:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        sms=findViewById(R.id.sms)
        call=findViewById(R.id.call)
        share=findViewById(R.id.share)
        camera=findViewById(R.id.camera)
        mpesa=findViewById(R.id.mpesa)
        dial=findViewById(R.id.dial)
        email=findViewById(R.id.Email)

        sms.setOnClickListener {
            val uri=Uri.parse("smsto:0712645980")
            val intent=Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("Hello","Good morning")
            startActivity(intent)
        }
        camera.setOnClickListener {
            val takepic = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takepic,1)
        }
        dial.setOnClickListener {
            val simu="+254721747599"
            val intent = Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",simu,null))
            startActivity(intent)
        }
        mpesa.setOnClickListener {
            val simToolKitLaunchIntent=
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let {startActivity(it)}
        }
        share.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,"Hi, click to download")
            startActivity(shareIntent)
        }
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"+254721747599"))
            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    android.Manifest.permission.CALL_PHONE
            )!=PackageManager.PERMISSION_GRANTED
            ){
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),1
                )
            }else{
                startActivity(intent)
            }
        }
        email.setOnClickListener {
            val emailint = Intent(
                Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "stanflixmcochieng@gmail.com", null)
            )
            emailint.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailint.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailint, "send email..."))
        }
    }
}