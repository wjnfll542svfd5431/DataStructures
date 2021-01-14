package com.jbit.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �沨�����ʽ
 */
public class PolandNotation {
    public static void main(String[] args) {

        /*String str = "3 4 + 2 * 1 -";
        List<String> list = PolandNotation.getList(str);
        System.out.print("���ʽΪ��"+str);
        System.out.println("���Ϊ��"+PolandNotation.calculate(list));*/
        String str = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        System.out.println("��׺Ϊ"+str);
        List<String> list = parseSuffixExpreesionList(str);
        System.out.println("ת����Ϊ"+list);
        System.out.print("���Ϊ"+calculate(list));
    }

    /**
     * ��׺���ʽת��׺���ʽ
     * @param str ���ʽ
     * @return
     */
    public static List<String> parseSuffixExpreesionList(String str){
        //����ջ
        Stack<String> charStack = new Stack<String>();
        //�м���ջ
        List<String> resStack = new ArrayList<String>();
        List<String> resList = getList(str);
        //�������ʽ
        for(String item:resList){
            //�ж��Ƿ�Ϊ����
            if(item.matches("\\d+")){
                resStack.add(item);
            }else if(item.equals("(")){
                charStack.push(item);
            }else if(item.equals(")")){
                if(!charStack.peek().equals("(")){
                    //������������м�ջ��
                    resStack.add(charStack.pop());
                }
                //������
                charStack.pop();
            }else{

                while(charStack.size() != 0 && Operation.getValue(item) <= Operation.getValue(charStack.peek())){
                    resStack.add(charStack.pop());
                }
                charStack.push(item);
            }
        }
        if(charStack.size()!=-1){
            resStack.add(charStack.pop());
        }
        return resStack;
    };


    /**
     * �����ʽת�뵽list�з������
     * @param str
     */
    public static List getList(String str){
        String [] strings = str.split(" ");
        List<String> list = new ArrayList<String>();
        for (String item : strings) {
            list.add(item);
        }
        return list;
    };

    /**
     * ���м���
     * @param list
     * @return
     */
    public static int calculate(List<String> list){
        //����ջ
        Stack<String> stack = new Stack<String>();
        for (String  item: list) {
            //�ж��Ƿ�Ϊ��
            if(item.matches("\\d+")){
                stack.push(item);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                switch (item){
                    case "+":
                         stack.push( num1+num2+"");
                         break;
                    case "-":
                        stack.push(num1-num2+"");
                        break;
                    case "*":
                        stack.push(num1*num2+"");
                        break;
                    case "/":
                        stack.push(num1/num2+"");
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
        }
        return Integer.parseInt(stack.pop());
    };
}
class  Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int SVG=2;
    private static int MUL=2;


    public static int getValue(String ar){
        switch (ar){
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return SVG;
            default:
                break;
        };
        return 0;
    }
}
