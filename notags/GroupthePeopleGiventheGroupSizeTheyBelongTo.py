

class Solution:
    def groupThePeople(self, groupSizes):
        A = {}
        for i,size in enumerate(groupSizes):
            if size not in A:
                A[size] = []
            A[size].append(i)

        res = []
        for size in A:
            for i in range(0,A[size],size):
                res.append(A[size][i:i+size])
        return res

if __name__ == "__main__":
    a = Solution()
    print(a.groupThePeople([3,3,3,3,3,1,3]))
    print("h")