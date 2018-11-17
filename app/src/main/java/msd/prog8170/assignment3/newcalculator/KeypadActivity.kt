package msd.prog8170.assignment3.newcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

enum class Operations {
    NOOP, ADD, SUB, MUL, DIV
}

class KeypadActivity : AppCompatActivity() {

    private var lhs = ""
    private var rhs = ""
    private var currentOperation = Operations.NOOP

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
                if (digit == '.' && len == 0) {
                    rhs += '0'
                }
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
            R.id.op_add -> pushOperator(Operations.ADD)
            R.id.op_sub -> pushOperator(Operations.SUB)
            R.id.op_mul -> pushOperator(Operations.MUL)
            R.id.op_div -> pushOperator(Operations.DIV)
            R.id.dot -> pushDigit('.')
            R.id.equals -> doEquals()
        }
    }

    private fun pushOperator(operation: Operations) {
        if (currentOperation != Operations.NOOP) {
            doEquals()
        }
    }

    private fun getNumber(numStr: String) : Double {
        if (numStr.isEmpty()) {
            return 0.0
        }
        return numStr.toDouble()
    }

    private fun doAdd() {}

    private fun doSub() {}

    private fun doMul() {}

    private fun doDiv() {}

    private fun doEquals() {
        when(currentOperation) {

        }
    }
}
