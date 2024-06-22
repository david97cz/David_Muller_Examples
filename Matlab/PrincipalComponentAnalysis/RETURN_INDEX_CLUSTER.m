function [set_index] = RETURN_INDEX_CLUSTER(Y,idx,class)
set_index = [];
    for i =1:length(Y)
        if idx(i) == class
        set_index=[set_index;i];
        end
    end

end