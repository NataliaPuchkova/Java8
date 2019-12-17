public class CompactString{
        public static void main(String...arg){
                System.out.println(clean("aassddffggh"));
                System.out.println(clean(null));
                System.out.println(clean(""));
                System.out.println(clean("aaaaaaaa"));
                System.out.println(clean("a"));
        }

        public static String clean(String s){
                StringJoiner str = new StringJoiner("");
                if (s!=null && s.length()>0){
                        char[] cc = new char[1];
                        cc[0] = s.charAt(0);
                        str.add(""+cc[0]);
                        s.chars()
                                .map(x->(char) x)
                                .forEach(y->{
                                        if ((char) y!=cc[0]) {
                                                str.add(""+(char) y);
                                                cc[0] = (char) y;
                                        }
                                });
                }
                return str.toString();
        }

}
