package com.avmap.parsejson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.avmap.parsejson.databinding.ActivityMainBinding
import com.avmap.parsejson.model.Users
import com.google.gson.Gson
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        try {
            val jsonString = getJSONFromAssets()!!
            val users = Gson().fromJson(jsonString, Users::class.java)

            // Set the LayoutManager that this RecyclerView will use.
            mBinding.rvUsersList.layoutManager = LinearLayoutManager(this)

            // Adapter class is initialized and list is passed in the param.
            val itemAdapter = UserAdapter(this, users.users)
            // adapter instance is set to the recyclerview to inflate the items.
            mBinding.rvUsersList.adapter = itemAdapter
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

    }

    /**
     * Method to load the JSON from the Assets file and return the object
     */
    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("Users.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}