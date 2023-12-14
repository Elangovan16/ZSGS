package com.elangovan16.leetcode;

public class AddBinary {
	public static void main(String[] args) {//67. Add Binary
		AddBinary ab=new AddBinary();
		String a="1010";
		String b="1011";
		System.out.println(ab.addBinary(a, b));
	}
    public String addBinary(String a, String b) {
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder sb=new StringBuilder();

        while(i>=0 || j>=0 || carry==1){
            if(i>=0)
                carry += a.charAt(i--) - '0';
            if(j>=0)
                carry += b.charAt(j--) - '0';
            sb.insert(0,carry%2);
            carry/=2;
        }
        return sb.toString();
    }
}
