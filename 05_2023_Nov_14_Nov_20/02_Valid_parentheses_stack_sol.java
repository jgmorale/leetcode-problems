import java.util.*;

// Pass 100% of test cases
class Solution {
    private Stack<Character> stack = new Stack<Character>();
    private HashSet<Character> endP = new HashSet<Character>();
    private Map<Character,Character> mapping = new HashMap<Character, Character>();

    public boolean isValid(String s) {
        if (s.length() == 1) return false;
        initDS();
        Stack<Character> stack = getStack();

        if(isEndParenthesis(s.charAt(0))) return false;
        stack.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            Character c = s.charAt(i);
            Character closure = getExpectedClosure();
            if(isEndParenthesis(c)){
                if (closure != c) return false;
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        if (!stack.isEmpty()) return false;
        return true;
    }

    public boolean isEndParenthesis(Character c){
        return this.endP.contains(c);
    }

    public Character getExpectedClosure(){
        if (this.stack.isEmpty()) return null;
        return this.mapping.get(this.stack.peek());
    }

    public void initDS(){
        this.endP.add(')');
        this.endP.add('}');
        this.endP.add(']');

        this.mapping.put('(', ')');
        this.mapping.put('{', '}');
        this.mapping.put('[',']');
    }

    public Stack<Character> getStack(){
        return this.stack;
    }

    public HashSet<Character> getEndP(){
        return this.endP;
    }

    public Map<Character,Character> getMapping(){
        return this.mapping;
    }
}