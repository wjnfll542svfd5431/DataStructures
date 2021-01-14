package com.jbit.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class PolandNotation {
    public static void main(String[] args) {

        /*String str = "3 4 + 2 * 1 -";
        List<String> list = PolandNotation.getList(str);
        System.out.print("表达式为："+str);
        System.out.println("结果为："+PolandNotation.calculate(list));*/
        String str = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        System.out.println("中缀为"+str);
        List<String> list = parseSuffixExpreesionList(str);
        System.out.println("转换后为"+list);
        System.out.print("结果为"+calculate(list));
    }

    /**
     * 中缀表达式转后缀表达式
     * @param str 表达式
     * @return
     */
    public static List<String> parseSuffixExpreesionList(String str){
        //运算栈
        Stack<String> charStack = new Stack<String>();
        //中间结果栈
        List<String> resStack = new ArrayList<String>();
        List<String> resList = getList(str);
        //遍历表达式
        for(String item:resList){
            //判断是否为数字
            if(item.matches("\\d+")){
                resStack.add(item);
            }else if(item.equals("(")){
                charStack.push(item);
            }else if(item.equals(")")){
                if(!charStack.peek().equals("(")){
                    //将运算符存入中间栈中
                    resStack.add(charStack.pop());
                }
                //弹出（
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
     * 将表达式转入到list中方便遍历
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
     * 进行计算
     * @param list
     * @return
     */
    public static int calculate(List<String> list){
        //创建栈
        Stack<String> stack = new Stack<String>();
        for (String  item: list) {
            //判断是否为数
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
