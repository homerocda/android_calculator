package msd.prog8170.assignment3.newcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class KeypadActivity : AppCompatActivity() {

    private var lhs = ""
    private var rhs = ""
    private val display : TextView
        get() = findViewById(R.id.tv_display)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keypad)
    }

    private fun pushDigit(digit: Char) {
        val len = rhs.length
        if (len < 10) {
            if (digit != '0' || len > 0) {
                rhs += digit
                display.text = rhs
            }
        }
    }

    fun onDigit(view: View?) {
        when (view?.id) {
            R.id.digit_0 -> pushDigit('0')
            R.id.digit_1 -> pushDigit('1')
            R.id.digit_2 -> pushDigit('2')
            R.id.digit_3 -> pushDigit('3')
            R.id.digit_4 -> pushDigit('4')
            R.id.digit_5 -> pushDigit('5')
            R.id.digit_6 -> pushDigit('6')
            R.id.digit_7 -> pushDigit('7')
            R.id.digit_8 -> pushDigit('8')
            R.id.digit_9 -> pushDigit('9')
        }
    }

    fun onOperator(view: View?) {
        when (view?.id) {
            R.id.op_add -> doAdd()
            R.id.op_sub -> doSub()
            R.id.op_mul -> doMul()
            R.id.op_div -> doDiv()
            R.id.dot -> doDot()
            R.id.equals -> doEquals()
        }
    }

    private fun doAdd() {}

    private fun doSub() {}

    private fun doMul() {}

    private fun doDiv() {}

    private fun doDot() {
        pushDigit('.')
    }

    private fun doEquals() {}
}
