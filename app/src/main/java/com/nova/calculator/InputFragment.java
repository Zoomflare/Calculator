package com.nova.calculator;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import org.mariuszgromada.math.mxparser.*;

public class InputFragment extends Fragment {
    private EditText display;
    private ImageButton backspace;
    private Button Btn0;
    private Button Btn1;
    private Button Btn2;
    private Button Btn3;
    private Button Btn4;
    private Button Btn5;
    private Button Btn6;
    private Button Btn7;
    private Button Btn8;
    private Button Btn9;
    private Button addBtn;
    private Button subBtn;
    private Button multiplyBtn;
    private Button divideBtn;
    private Button equalBtn;
    private Button pointBtn;
    private Button clearBtn;
    private Button bracketBtn;
    private Button expoBtn;
    private CalculatorFragmentListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calculator_fragment, container, false);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        display = view.findViewById(R.id.inputText);
        display.setShowSoftInputOnFocus(false);
        Btn0 = view.findViewById(R.id.zeroButton);
        Btn1 = view.findViewById(R.id.oneButton);
        Btn2 = view.findViewById(R.id.twoButton);
        Btn3 = view.findViewById(R.id.threeButton);
        Btn4 = view.findViewById(R.id.fourButton);
        Btn5 = view.findViewById(R.id.fiveButton);
        Btn6 = view.findViewById(R.id.sixButton);
        Btn7 = view.findViewById(R.id.sevenButton);
        Btn8 = view.findViewById(R.id.eightButton);
        Btn9 = view.findViewById(R.id.nineButton);
        addBtn = view.findViewById(R.id.addButton);
        subBtn = view.findViewById(R.id.subtractButton);
        multiplyBtn = view.findViewById(R.id.multiplyBUtton);
        divideBtn = view.findViewById(R.id.divisionButton);
        equalBtn = view.findViewById(R.id.equalsButton);
        pointBtn = view.findViewById(R.id.pointButton);
        clearBtn = view.findViewById(R.id.clearButton);
        bracketBtn = view.findViewById(R.id.bracketButton);
        expoBtn = view.findViewById(R.id.powerButton);
        backspace = view.findViewById(R.id.backspaceButton);


        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("1");

            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("1");

            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("2");

            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("3");

            }
        });
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("4");

            }
        });
        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("5");

            }
        });
        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("6");

            }
        });
        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("7");

            }
        });
        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("8");

            }
        });
        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("9");

            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("+");

            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("-");

            }
        });
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("*");

            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("/");

            }
        });
        pointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(".");

            }
        });
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String expression = display.getText().toString();
                Expression mathExpression = new Expression(expression);
                String result = String.valueOf(mathExpression.calculate());
                listener.sendResult(result);
                display.setText("");
            }
        });
        bracketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursorPos = display.getSelectionStart();
                int openBracket = 0 , closedBracket = 0;
                int len = display.getText().length();

                for (int i = 0; i<cursorPos; i++){
                    if(display.getText().toString().substring(i, i++).equals("(")){
                        openBracket++;
                    }
                }
                for (int i = 0; i<cursorPos; i++){
                    if(display.getText().toString().substring(i, i++).equals(")")){
                        closedBracket++;
                    }
                }

                if(openBracket == closedBracket || display.getText().toString().substring(len-1, len).equals("(")){
                    updateText("(");
                    display.setSelection(cursorPos+1);
                }

                if( closedBracket < openBracket  || !display.getText().toString().substring(len-1, len).equals(")")){
                    updateText(")");
                    display.setSelection(cursorPos+1);
                }

            }
        });
        expoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("^");

            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");

            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             int cursorPos = display.getSelectionStart();
                                             int textLength = display.getText().length();

                                             if(cursorPos!=0 || textLength!=0){
                                                 SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                                                 selection.replace(cursorPos-1, cursorPos, "");
                                                 display.setText(selection);
                                                 display.setSelection(cursorPos-1);
                                             }
                                         }
                                     }
        );
    }

    private void updateText(String stringTOAdd){
        String currentString = display.getText().toString();
        int cursorPos = display.getSelectionStart();

        String left = currentString.substring(0, cursorPos);
        String right = currentString.substring(cursorPos);

        if(display.getText().toString().equals("") || display.getText().toString() == null){
            display.setText(String.format(stringTOAdd));
            display.setSelection(cursorPos + 1);
        } else{
            display.setText(String.format("%s%s%s", left, stringTOAdd, right));            display.setSelection(cursorPos + 1);
            display.setSelection(cursorPos + 1);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (CalculatorFragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface CalculatorFragmentListener {
        void sendResult(String result);
    }

}
