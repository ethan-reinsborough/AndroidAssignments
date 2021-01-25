package com.example.assignment_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assignment_one.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var counter: Int = 0;
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        updateCounter();
        binding.countUpBtn.setOnClickListener { countUp() }
        binding.countDownBtn.setOnClickListener { countDown() }
        binding.toastBtn.setOnClickListener { displayCounter() }
    }

    private fun countDown() { counter--; updateCounter(); }

    private fun countUp() { counter++; updateCounter(); }

    private fun updateCounter() { binding.countDisplay.text = counter.toString(); }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    private fun displayCounter(){
        Toast.makeText(this, "Hello, your current count is: $counter", Toast.LENGTH_SHORT).show();
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        updateCounter();
    }
}