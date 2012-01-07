package com.paulbutcher.mrsdoyle

import Utils.pickRandom

object Utterances {
  
  def invitation = pickRandom(
    "Will you have a cup of tea?", 
    "Will you have a cup of tea father?", 
    "We were just about to have a cup of tea, will you join us?", 
    "Join us in a cup of tea?", 
    "Tea perchance?", 
    "Could I interest you in a brew?", 
    "Hot beverage?", 
    "Tea for two, two for tea... will you join us?",
    "What would you say to a cup father?",
    "Fancy a cup o' the hot stuff?")
    
  def goodIdea = pickRandom(
    "Fantastic idea, I'll see who else wants one and get back to you in a couple of minutes", 
    "I was just about to suggest the same thing. I'll see who else wants one", 
    "Coming right up... in a couple of minutes", 
    "You do have the best ideas, I'll see who else will join us")
    
  def whatDidYouSay = pickRandom(
    "I don't understand what you're saying...",
    "If it's not about tea, I'm afraid I'm not really interested...",
    "Pardon?",
    "Beg pardon?",
    "Hm?",
    "Umm.....",
    "Pancakes.",
    "I fail to see the relevance...",
    "Is there something I can do for you?",
    "Are you sure you're speaking English?",
    "Now really, whatever does that mean?",
    "I'm afraid I'm just not familiar with this new slang you young people use.",
    "You always say that!")
    
  def greatNews = pickRandom(
    "Ah, grand! I'll wait a couple of minutes and see if anyone else wants one", 
    "Champion.", 
    "You won't regret it!", 
    "Wonderful!", 
    "I'm so glad!", 
    "Marvellous!", 
    "Oh good, I do like a cup of tea!", 
    "Fabulous!")
    
  def youreIt = pickRandom(
    "Well volunteered! The following other people want tea!",
    "Be a love and put the kettle on would you?",
    "You know what, I think it's your turn to make the tea now I think about it.",
    "Polly put the kettle on, kettle on, kettle on. You are Polly in this game.",
    "Why not stretch those weary legs and have a wander over to the kitchen. Say, while you're there....")
    
  def willMake = pickRandom(
    " has been kind enough to make the tea, I'd do it myself only I don't have arms",
    " has been kind enough to make the tea",
    " kindly offered to make the tea",
    " is about to selflessly put the kettle on",
    " is today's lucky tea lady",
    " will soon bring you a warm fuzzy feeling in a cup")
}
