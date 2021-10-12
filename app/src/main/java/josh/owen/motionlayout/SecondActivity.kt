package josh.owen.motionlayout

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.constraintlayout.helper.widget.Carousel
import kotlinx.android.synthetic.main.activity_second.*
import android.widget.Toast

import android.widget.AdapterView.OnItemClickListener
import java.lang.String


class SecondActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 5
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun populate(view: View, index: Int) {
                view.setOnClickListener(this@SecondActivity)

                Toast.makeText(applicationContext, "Test : $index", Toast.LENGTH_SHORT).show()
            }

            override fun onNewItem(index: Int) {
                tvBirdName.text = "Tweet Tweet Bird : $index"
            }

        })
    }

    override fun onClick(view: View) {
        when (view) {
            imageView0 -> doThing(0)
            imageView1 -> doThing(1)
            imageView2 -> doThing(2)
            imageView3 -> doThing(3)
            imageView4 -> doThing(4)
        }
    }

    private fun doThing(viewClicked : Int) {
        startActivity(Intent(this, ThirdActivity::class.java))
    }

}