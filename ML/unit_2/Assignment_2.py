
# coding: utf-8

# # SVR

# In[79]:

import pandas as pd
import numpy as np


# In[80]:

ff = pd.read_csv('E:/assignment/5th_sem_mca/ML/Unit_2/Position_Salaries.csv')

ff.head()


# In[82]:

ff.describe()


# In[84]:

ff.keys()


# In[78]:

ff


# In[ ]:




# In[ ]:




# In[34]:

X = df.iloc[:, 1:2].values
Y = df.iloc[:, 2].values


# In[35]:

from sklearn.model_selection import train_test_split
X_Train, X_Test, Y_Train, Y_Test = train_test_split(X, Y, test_size = 0.2, random_state = 0)


# In[36]:

Y = Y.reshape(-1,1)


# In[37]:

from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
sc_Y = StandardScaler()
X = sc_X.fit_transform(X)
Y = sc_Y.fit_transform(Y)


# In[39]:

from sklearn.svm import SVR
regressor = SVR(kernel = 'rbf')
regressor.fit(X,Y)


# In[40]:

Y_Pred = sc_Y.inverse_transform(regressor.predict(sc_X.transform(np.array([6.5]).reshape(-1,1))))


# In[42]:

import matplotlib.pyplot as plt
plt.scatter(X,Y, color = 'red')
plt.plot(X, regressor.predict(X), color = 'blue')
plt.title('Regression Results')
plt.xlabel('Position level')
plt.ylabel('Salary')
plt.show()


# # SVM

# In[43]:

df = pd.read_csv('E:/assignment/5th_sem_mca/ML/Unit_2/apples_and_oranges.csv')

df.head()


# In[45]:

df.keys()


# In[72]:

df.info()


# In[73]:

df.describe()


# In[75]:

import matplotlib.pyplot as plt
plt.figure(figsize=(10, 10))
plt.scatter(df['Weight'], df['Size'], color=['black'])
plt.show()



# In[76]:

df.hist(figsize=(20, 10))


# In[77]:

df['Class'].value_counts().plot(kind='bar', figsize=(20, 10))


# In[53]:

X = df.iloc[:, [0,1]].values
y = df.iloc[:, 2].values


# In[54]:

X.shape
Y.shape


# In[55]:

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=1)


# In[56]:

from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.transform(X_test)


# In[58]:

from sklearn.svm import SVC
classifier = SVC(kernel='rbf', random_state=0)
classifier.fit(X_train, y_train)


# In[59]:

y_pred = classifier.predict(X_test)


# In[60]:

from sklearn.metrics import confusion_matrix
asdf = confusion_matrix(y_test, y_pred)


# In[61]:

df_asdf = df[['Weight', 'Size']].sample(5)


# In[63]:

sc_X = StandardScaler()
sample = sc_X.fit_transform(df_asdf)
classifier.predict(sample)


# In[65]:

df.iloc[list(df_asdf.index)]


# In[67]:

df_asdf['Actual'] = df.iloc[list(df_asdf.index)]['Class']
df_asdf['Prediction'] = classifier.predict(sample)
df_asdf


# In[ ]:



