SELECT friend.* FROM users friend, user_friend uf
WHERE uf.user_id = 1 AND uf.friend_id = friend.id;
select *from user_event