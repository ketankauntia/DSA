//refer video : https://www.youtube.com/watch?v=Nu0O84--xNQ

class Solution {
public:
    struct Robot{
        int index;
        int position;
        int health;
        char direction;
    };
   

    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        //finding no of elements
        int n = positions.size();

        //creating the new vector array and storing data into it.
        vector<Robot> arr;

        for(int i=0;i<n;i++){
            arr.push_back({i,positions[i],healths[i],directions[i]});
        }

        //sorting the data based on position
        sort(arr.begin(),arr.end(),[](const Robot &a, const Robot &b){
            return a.position < b.position;
        });

        stack<Robot> st;
        for(Robot& robot:arr){
            if(robot.direction == 'R'){
                st.push(robot);
            } else{
                handleCollision(st,robot);
            }
        }

        arr.clear();

        //transfering data from stack to vector array
        while(!st.empty()){
            arr.push_back(st.top());
            st.pop();
        }

        //sorted back based on index in the given order during input
        sort(arr.begin(),arr.end(), [](const Robot &a, const Robot &b){
            return a.index<b.index;
        });

        //storing health of the robots
        vector<int> ans;
        for(Robot r:arr){
            ans.push_back(r.health);
        }

        return ans;
    }

    void handleCollision(stack<Robot> &st, Robot& robot){
        while(!st.empty() && st.top().direction=='R' && st.top().health < robot.health){
            st.pop();
            robot.health--;
        }

        if(!st.empty() && st.top().direction=='R'){
            if(st.top().health == robot.health){
                st.pop();
            } else{
                st.top().health--;
            }
        } else{
            st.push(robot);
        }
    }
};