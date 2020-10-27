package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Problem8_StringToInteger {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        while (i < chars.length && Character.isSpaceChar(chars[i])) {
            i++;
        }

        if (i == chars.length
            || (chars[i] != '+' && chars[i] != '-' && !Character.isDigit(chars[i]))) {
            return 0;
        }

        boolean negative = false;
        if (chars[i] == '+' || chars[i] == '-') {
            negative = chars[i] == '-';
            i++;
        }

        long ret = 0;
        while (i < chars.length && Character.isDigit(chars[i])) {
            ret = ret * 10 + (chars[i]-'0');
            if (ret > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }
        ret = ret * (negative ? -1 : 1);

        if (ret > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ret < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)ret;
        }
    }

    public int myAtoiV2(String s) {
        StatedString ss = new StatedString(s);
        return ss.atoi();
    }

    private interface State {
        void transfer(char ch);
    }

    private class StatedString {
        private String s;

        private State spaceState;
        private State signState;
        private State numberState;
        private State endState;

        private State state;

        StatedString(String s) {
            this.s = s;
            this.spaceState = new SpaceState(this);
            this.signState = new SignState(this);
            this.numberState = new NumberState(this);
            this.endState = new EndState(this);
            this.state = spaceState;
        }

        public State getSpaceState() {
            return spaceState;
        }

        public State getSignState() {
            return signState;
        }

        public State getNumberState() {
            return numberState;
        }

        public State getEndState() {
            return endState;
        }

        public void setState(State state) {
            this.state = state;
        }

        public int atoi() {
            char[] chars = s.toCharArray();

            boolean negative = false;
            long ret = 0;
            for (char ch : chars) {
                state.transfer(ch);
                if (state.equals(signState)) {
                    negative = ch == '-' ? true : false;
                } else if (state.equals(numberState)) {
                    ret = ret * 10 + (ch - '0');
                    if (ret > Integer.MAX_VALUE) {
                        break;
                    }
                } else if (state.equals(endState)) {
                    break;
                }
            }
            ret = ret * (negative ? -1 : 1);

            if (ret > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (ret < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int)ret;
            }
        }
    }

    private class SpaceState implements State {
        private StatedString ss;

        SpaceState(StatedString ss) {
            this.ss = ss;
        }

        @Override
        public void transfer(char ch) {
            if (Character.isSpaceChar(ch)) {
                ss.setState(ss.getSpaceState());
            } else if (ch == '+' || ch == '-') {
                ss.setState(ss.getSignState());
            } else if (Character.isDigit(ch)) {
                ss.setState(ss.getNumberState());
            } else {
                ss.setState(ss.getEndState());
            }
        }
    }

    private class SignState implements State {
        private StatedString ss;

        SignState(StatedString ss) {
            this.ss = ss;
        }

        @Override
        public void transfer(char ch) {
            if (Character.isDigit(ch)) {
                ss.setState(ss.getNumberState());
            } else {
                ss.setState(ss.getEndState());
            }
        }
    }

    private class NumberState implements State {
        private StatedString ss;

        NumberState(StatedString ss) {
            this.ss = ss;
        }

        @Override
        public void transfer(char ch) {
            if (Character.isDigit(ch)) {
                ss.setState(ss.getNumberState());
            } else {
                ss.setState(ss.getEndState());
            }
        }
    }

    private class EndState implements State {
        private StatedString ss;

        EndState(StatedString ss) {
            this.ss = ss;
        }

        @Override
        public void transfer(char ch) {
            ss.setState(ss.getEndState());
        }
    }

    private enum StateEnum {
        SPACE, SIGN, NUMBER, END
    }

    public int myAtoiV3(String s) {
        AtoiAutomaton atoiAutomaton = new AtoiAutomaton(s);
        return atoiAutomaton.atoi();
    }

    private class AtoiAutomaton {
        private String s;

        private StateEnum state = StateEnum.SPACE;
        private boolean negative = false;
        private long ret = 0;

        private Map<StateEnum, StateEnum[]> transfer = new HashMap<StateEnum, StateEnum[]>() {{
            put(StateEnum.SPACE,
                new StateEnum[] {StateEnum.SPACE, StateEnum.SIGN, StateEnum.NUMBER, StateEnum.END});
            put(StateEnum.SIGN,
                new StateEnum[] {StateEnum.END, StateEnum.END, StateEnum.NUMBER, StateEnum.END});
            put(StateEnum.NUMBER,
                new StateEnum[] {StateEnum.END, StateEnum.END, StateEnum.NUMBER, StateEnum.END});
            put(StateEnum.END,
                new StateEnum[] {StateEnum.END, StateEnum.END, StateEnum.END, StateEnum.END});
        }};

        public AtoiAutomaton(String s) {
            this.s = s;
        }

        public int atoi() {
            for (char ch : s.toCharArray()) {
                transfer(ch);

                if (state.equals(StateEnum.SIGN)) {
                    negative = ch == '-' ? true : false;
                } else if (state.equals(StateEnum.NUMBER)) {
                    ret = ret * 10 + (ch - '0');
                    if (ret > Integer.MAX_VALUE) {
                        break;
                    }
                } else if (state.equals(StateEnum.END)) {
                    break;
                }
            }
            ret = ret * (negative ? -1 : 1);

            if (ret > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (ret < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int)ret;
            }
        }

        private void transfer(char ch) {
            int index = computeIndex(ch);
            state = transfer.get(state)[index];
        }

        private int computeIndex(char ch) {
            int index;
            if (Character.isSpaceChar(ch)) {
                index = 0;
            } else if (ch == '+' || ch == '-') {
                index = 1;
            } else if (Character.isDigit(ch)) {
                index = 2;
            } else {
                index = 3;
            }

            return index;
        }
    }

    public static void main(String[] args) {
        Problem8_StringToInteger obj = new Problem8_StringToInteger();
        System.out.println(obj.myAtoiV3("-13+8"));
        System.out.println(obj.myAtoiV3("42"));
        System.out.println(obj.myAtoiV3("   -42"));
        System.out.println(obj.myAtoiV3("4193 with words"));
        System.out.println(obj.myAtoiV3("words and 987"));
    }
}
