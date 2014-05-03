class Solution:
    # @return an integer
    def atoi(self, str):
        res=0;sign=1;flag=False;length=len(str)
        for i in range(length):
            if not flag:
                if str[i]=='-':
                    flag=True;sign=-1;continue
                elif str[i]=='+':
                    flag=True;sign=1;continue
                elif str[i]!=' ' and (str[i]>'9' or str[i]<'0'):
                    return 0
            else:
                if str[i]<'0' or str[i] >'9':
                    break
            if str[i]>='0' and str[i]<='9':
                flag = True
                if (res>214748364 and sign<0) or (res==214748364 and str[i]>'8' and sign<0):
                    return -2147483648
                elif (res>214748364 and sign>0) or (res==214748364 and str[i]>'7' and sign>0):
                    return 2147483647
                res = int(res)*10+int(str[i])-int('0')
        if sign<0:
            return 0-res
        return res