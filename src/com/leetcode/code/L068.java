package com.leetcode.code;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: xiaoliyu
 * @date: 2019-11-14 14:13
 */
/*这个题主要有三种情况，遍历字符串数组时，
  在当前一行加入一个新的单词，正好将当前行填满
  在当前一行加入一个新的单词，超出了maxWidth，就要分配剩下的空格
  在当前一行加入一个新的单词，没有超出
  注意，每一行第一个单词计算长度的时候不用放空格

  做这种题不能图省事，，，比如我这里将放第一个单词的情况和放不满，放满，放超了一起判断的，，，就要多想好多细节，不如分开，可以最后优化的时候合起来
* */
public class L068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();

        //记录当前行的起点
        int start=0;
        //记录当前行已经放进几个单词去了
        int size=0;
        //遍历输入的字符串数组

        //记录每一行的长度
        int lineWidth=0;

        for(int i=0;i<words.length;){
            //第一种情况，加一个空格正好将一行填满  **第一个单词不加空格
            if(lineWidth+words[i].length()+(size==0?0:1)==maxWidth){
                result.add(buildString(start,size+1,words,0));

                start=start+size+1;//新一行的起点是下一个单词了
                size=0;//单词个数加一
                lineWidth=0;
                i++;
            }
            //第二种情况，在当前一行加入一个新的单词，超出了maxWidth，就要分配剩下的空格
            else if(lineWidth+words[i].length()+(size==0?0:1)>maxWidth){
                result.add(buildString(start,size,words,maxWidth-lineWidth));
                start=start+size;//新一行的起点是下一个单词了
                size=0;//单词个数加一
                lineWidth=0;
            //第三种情况，在当前一行加入一个新的单词，没有超出
            }else if(lineWidth+words[i].length()+(size==0?0:1)<maxWidth){

                //第一个单词不计算上空格
                if(size==0){
                    lineWidth=lineWidth+words[i].length();
                }
                else {
                    lineWidth = lineWidth + words[i].length() + 1;
                }
                size=size+1;
                i++;
            }

        }
        if(lineWidth>0){
            result.add(buildLast(start,size,words)+getBlank(maxWidth-lineWidth));
        }

        return result;
    }
    //通过新的一行起点，和要放入的单词的个数，以及剩下的空格数，
    public String buildString(int start,int size,String[] words,int blank_space){
        StringBuilder str=new StringBuilder();
        //如果正好填满
        if(blank_space==0){

            for(int k=0;k<size;k++){
                if(k==0){
                    str.append(words[start]);
                }else {
                    str.append(" " + words[start + k]);
                }
            }
        }
        //如果空格有剩余
        else{
            //如果只有一个
            if(size==1){
             str.append(words[start]+getBlank(blank_space));
            }else {
                //分配空格
                //商
                int merchant = blank_space / (size == 1 ? 1 : (size - 1));
                //余数
                int remainder = blank_space % (size == 1 ? 1 : (size - 1));
                for (int k = 0; k < size; k++) {
                    //按照除完的结果分配空格
                    if (k == 0) {
                        str.append(words[start]);
                        //左边要多分配空格
                    } else if (k <= remainder) {
                        str.append(getBlank(merchant) + "  " + words[start + k]);
                    } else {
                        str.append(getBlank(merchant) + " " + words[start + k]);
                    }

                }
            }
        }

        return str.toString();
    }

    //最后一行
    public String buildLast(int start,int size,String[] words){
        StringBuilder str=new StringBuilder("");
        for(int k=0;k<size;k++){
            if(k==0){
                str.append(words[start]);
            }else {
                str.append(" " + words[start + k]);
            }
        }
        return str.toString();
    }

    public String getBlank(int size){
        StringBuilder str=new StringBuilder("");
        for(int q=0;q<size;q++)
            str.append(" ");
        return str.toString();
    }

    public static void main(String[] args) {
        L068 l068 = new L068();
        String[] words= {"This", "is", "an", "example", "of", "text", "justification."};//16
        String[] words2={"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}; //16
        String[] words3={"What","must","be","acknowledgment","shall","be"};//16
        List<String> list = l068.fullJustify(words3, 16);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
